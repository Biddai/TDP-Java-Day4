package numcollection;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class NumCollection implements Iterable<Integer> {
    // Teaching cutoff; callers do not need to know which strategy is selected.
    private static final long MAX_SMALL_SPAN = 1000;
    private final List<Range> ranges;
    private final Membership membership;

    public NumCollection(String input) {
        ranges = RangeParser.parse(input);
        int minimum = ranges.get(0).getStart();
        int maximum = ranges.get(ranges.size() - 1).getEnd();
        long span = (long) maximum - minimum;
        if (span <= MAX_SMALL_SPAN) {
            membership = new SmallSpanMembership(ranges);
        } else {
            membership = new RangeMembership(ranges);
        }
    }

    public boolean contains(int number) {
        return membership.contains(number);
    }

    private interface Membership {
        boolean contains(int number);
    }

    private static final class SmallSpanMembership implements Membership {
        private final int minimum;
        private final boolean[] present;

        SmallSpanMembership(List<Range> ranges) {
            minimum = ranges.get(0).getStart();
            int maximum = ranges.get(ranges.size() - 1).getEnd();
            long span = (long) maximum - minimum;
            present = new boolean[(int) span + 1];
            for (Range range : ranges) {
                int firstIndex = (int) ((long) range.getStart() - minimum);
                int lastIndex = (int) ((long) range.getEnd() - minimum);
                for (int index = firstIndex; index <= lastIndex; index++) {
                    present[index] = true;
                }
            }
        }

        public boolean contains(int number) {
            long index = (long) number - minimum;
            if (index < 0 || index >= present.length) {
                return false;
            }
            return present[(int) index];
        }
    }

    private static final class RangeMembership implements Membership {
        private final List<Range> ranges;

        RangeMembership(List<Range> ranges) {
            this.ranges = ranges;
        }

        public boolean contains(int number) {
            for (Range range : ranges) {
                if (number < range.getStart()) {
                    return false;
                }
                if (number <= range.getEnd()) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NumberIterator(ranges);
    }

    // Every iterator has its own cursor and produces one value at a time.
    private static final class NumberIterator implements Iterator<Integer> {
        private final List<Range> ranges;
        private int rangeIndex;
        private long nextValue;

        NumberIterator(List<Range> ranges) {
            this.ranges = ranges;
            this.rangeIndex = 0;
            this.nextValue = ranges.get(0).getStart();
        }

        @Override
        public boolean hasNext() {
            return rangeIndex < ranges.size();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int result = (int) nextValue;
            Range currentRange = ranges.get(rangeIndex);
            if (nextValue == currentRange.getEnd()) {
                rangeIndex++;
                if (hasNext()) {
                    nextValue = ranges.get(rangeIndex).getStart();
                }
            } else {
                nextValue++;
            }
            return result;
        }
    }
}
