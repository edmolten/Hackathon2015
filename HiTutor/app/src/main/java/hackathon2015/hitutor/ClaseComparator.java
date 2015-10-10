package hackathon2015.hitutor;

import java.util.Comparator;

import hackathon2015.hitutor.clases_result.Clase;

public enum ClaseComparator implements Comparator<Clase> {
    PRICE_SORT {
        public int compare(Clase o1, Clase o2) {
            return Integer.valueOf(o1.price).compareTo(o2.price);
        }},

    RATE_SORT {
        public int compare(Clase o1, Clase o2) {
            return Float.valueOf(o1.rate).compareTo(o2.rate);
        }
    };
    public static Comparator<Clase> decending(final Comparator<Clase> other) {
        return new Comparator<Clase>() {
            public int compare(Clase o1, Clase o2) {
                return -1 * other.compare(o1, o2);
            }
        };
    }
    public static Comparator<Clase> ascending(final Comparator<Clase> other) {
        return new Comparator<Clase>() {
            public int compare(Clase o1, Clase o2) {
                return -1 * other.compare(o2, o1);
            }
        };
    }
    public static Comparator<Clase> getComparator(final ClaseComparator... multipleOptions) {
        return new Comparator<Clase>() {
            public int compare(Clase o1, Clase o2) {
                for (ClaseComparator option : multipleOptions) {
                    int result = option.compare(o1, o2);
                    if (result != 0) {
                        return result;
                    }
                }
                return 0;
            }
        };
    }
}