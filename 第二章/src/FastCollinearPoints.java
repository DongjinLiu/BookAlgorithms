
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/*
 * Copyright (C) 2016 Michael <GrubenM@GMail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author Michael <GrubenM@GMail.com>
 */
public class FastCollinearPoints {
    private LineSegment[] segments;
    private int segmentSize;
    private Point[] collinear;
    private int collinearSize;
    private Point[] pts; // mutates for each new "origin"
    
    /**
     * Given a collection of unsorted points, stores all line segments
     * containing 4 or more points.
     * @param points 
     */
    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new java.lang.NullPointerException();
        
        /**
         * We have three points arrays: points, ptsNullCheck, and pts.
         * 
         * Checking for null points goes way faster if we've already sorted
         * the points array, but the API requires that we can't mutate the
         * incoming points.  Hence we make ptsNullCheck, and sort that.
         * 
         * Additionally, when we're iterating over each point in our main
         * for loop below, we need to have consistent indexing, or the
         * loop will miss some points and/or consider some points more than
         * once.  Hence we create pts, and re-sort that for each new point
         * under consideration, according to the next point in ptsNullCheck.
         */
        Point[] ptsNullCheck = points.clone();
        Arrays.sort(ptsNullCheck);
        for (int i = 0; i < ptsNullCheck.length - 1; i++) {
            if (ptsNullCheck[i] == null) throw new java.lang.NullPointerException();
            if (ptsNullCheck[i].compareTo(ptsNullCheck[i + 1]) == 0)
                throw new java.lang.IllegalArgumentException();
        }
        
        // Store the segments we've found in a ResizingArray
        segments = new LineSegment[1];
        segmentSize = 0;
        
        pts = ptsNullCheck.clone();
        
        for (int p = 0; p < pts.length; p++) {
            Arrays.sort(pts, ptsNullCheck[p].slopeOrder());
            /**
             * Since p.compareTo(p) returns Double.NEGATIVE_INFINITY, p is
             * always the first point in our sorted array.
             * 
             * Thus, we start j at 1 so we don't compare the current point to
             * itself, which wouldn't yield meaningful information.
             */
            for (int j = 1; j < pts.length; j++) {
                /**
                 * Store collinear points in a ResizingArray.
                 * It will probably need to hold 4 Points.
                 */
                collinear = new Point[4];
                collinearSize = 0;
                
                /**
                 * Make our first comparison, and add these points to collinear.
                 * (any two points are collinear)
                 */
                double slopeA = pts[0].slopeTo(pts[j]);
                enqueue(pts[0]);
                enqueue(pts[j]);
                
                /**
                 * Check to see if the next j index would put us outside of
                 * the pts array, then see if the Point at that index has
                 * the same slope as slopeA.
                 * If so, add the Point at that index to our collinear array.
                 */
                while (++j < pts.length && 
                        slopeA == pts[0].slopeTo(pts[j])) {
                    enqueue(pts[j]);
                }
                j--; // Since we peeked ahead with j above, move j back.
                
                if (collinearSize >= 4) {
                    
                    /**
                     * collinear holds the collinear points we've found so far,
                     * but we don't know which two are the endpoints.
                     * 
                     * Without sorting, we run the risk of mis-stating the
                     * points that define the line segment when we enqueue to
                     * segments.
                     * 
                     * Unfortunately, we can't just sort collinear, since it's a
                     * ResizingArray, and probably contains null elements.
                     * 
                     * So, copy the Points from collinear into toAdd, sort
                     * toAdd, then add its first and last Points as a
                     * LineSegment to segments.
                     */
                    Point[] toAdd = new Point[collinearSize];
                    for (int k = 0; k < collinearSize; k++) {
                        toAdd[k] = collinear[k];
                    }
                    Arrays.sort(toAdd);
                    
                    /**
                     * Ensure we're only adding top-down (or right-to-left)
                     * line segments.
                     * 
                     * Line segment A-B is the same segment as line segment B-A,
                     * but we can't add them both or we'll have duplicates.
                     * 
                     * Accordingly, arbitrarily, only add line segments where
                     * the current point being considered is above all other
                     * points (or, if horizontal, is to the right of all other
                     * points).  This should eliminate the A-B B-A symmetry,
                     * favoring one and excluding the other.
                     */
                    if (anyAbove(j)) {
                        enqueue(new LineSegment(toAdd[0],
                                toAdd[collinearSize - 1]));
                    }
                }
            }
        }
    }
    
    /**
     * Determines whether any of the points to be added are above
     * (or to the right of) the point currently being considered.
     * 
     * This is useful because a line segment can be defined from either
     * direction, but if we don't want duplicates in our segments array,
     * we need to arbitrarily decide not to add from one direction.
     * 
     * Thus, arbitrarily, this method determines whether any of the points
     * in the collinear segment to be added are above (or to the right of,
     * if horizontal) the point being considered.
     */
    private boolean anyAbove(int j) {
        for (int k = 0; k < collinearSize - 1; k++)
            if (pts[0].compareTo(pts[j - k]) < 0)
                return false;
        return true;
    }
    /**
     * "Add the item"
     * "Throw a java.lang.NullPointerException if the client attempts to add a
     * null item"
     * 
     * Also doubles the length of the array when it is full.
     * 
     * Adapted from the RandomizedQueue assignment.
     */
    private void enqueue(LineSegment l)
    {
        if (l == null) throw new java.lang.NullPointerException();
        if (segmentSize == segments.length)
            resize(2 * segments.length, segments);
        segments[segmentSize++] = l;
    }
    
    /**
     * "Add the item"
     * "Throw a java.lang.NullPointerException if the client attempts to add a
     * null item"
     * 
     * Also doubles the length of the array when it is full.
     * 
     * Adapted from the RandomizedQueue assignment.
     */
    private void enqueue(Point p)
    {
        if (p == null) throw new java.lang.NullPointerException();
        if (collinearSize == collinear.length)
            resize(2 * collinear.length, collinear);
        collinear[collinearSize++] = p;
    }
    
    /**
     * Resizes the array segments to [capacity].
     * 
     * This is a quadratic operation in the length of segments,
     * and so should only be performed sparingly.
     * 
     * Amortizing this cost over the number of operations which
     * can be performed in the new array, however,
     * the ResizingArray is constant.
     * 
     * Adapted from the RandomizedQueue assignment.
     */
    private void resize(int capacity, LineSegment[] l) {
        LineSegment[] copy = new LineSegment[capacity];
        for (int i = 0; i < segmentSize; i++) copy[i] = l[i];
        segments = copy;
    }
    
        /**
     * Resizes the array segments to [capacity].
     * 
     * This is a quadratic operation in the length of collinear,
     * and so should only be performed sparingly.
     * 
     * Amortizing this cost over the number of operations which
     * can be performed in the new array, however,
     * the ResizingArray is constant.
     * 
     * Adapted from the RandomizedQueue assignment.
     */
    private void resize(int capacity, Point[] p) {
        Point[] copy = new Point[capacity];
        for (int i = 0; i < collinearSize; i++) copy[i] = p[i];
        collinear = copy;
    }
    
    /**
     * Returns the number of line segments.
     * @return 
     */
    public int numberOfSegments() {
        return segmentSize;
    }
    
    /**
     * Returns a copy of the line segments in an array with no null elements.
     */
    public LineSegment[] segments() {
        LineSegment[] shrunk = new LineSegment[segmentSize];
        for (int i = 0; i < segmentSize; i++) shrunk[i] = segments[i];
        return shrunk;
    }
    
    /**
     * Unit Testing
     * @param args 
     */
    public static void main(String[] args) {

        // read the n points from a file
        In in = new In("collinear/grid5x5.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(-300, 32768);
        StdDraw.setYscale(-300, 32768);
        StdDraw.setPenRadius(0.015);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        StdDraw.setPenRadius();
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
