## method to compare String
    /**
     * A Comparator that orders <code>String</code> objects as by
     * <code>compareToIgnoreCase</code>. This comparator is serializable.
     * <p>
     * Note that this Comparator does <em>not</em> take locale into account,
     * and will result in an unsatisfactory ordering for certain locales.
     * The java.text package provides <em>Collators</em> to allow
     * locale-sensitive ordering.
     *
     * @see     java.text.Collator#compare(String, String)
     * @since   1.2
     */
    public static final Comparator<String> CASE_INSENSITIVE_ORDER
                                         = new CaseInsensitiveComparator();
    private static class CaseInsensitiveComparator
            implements Comparator<String>, java.io.Serializable {
        // use serialVersionUID from JDK 1.2.2 for interoperability
        private static final long serialVersionUID = 8575799808933029326L;

        public int compare(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 != c2) {
                    c1 = Character.toUpperCase(c1);
                    c2 = Character.toUpperCase(c2);
                    if (c1 != c2) {
                        c1 = Character.toLowerCase(c1);
                        c2 = Character.toLowerCase(c2);
                        if (c1 != c2) {
                            // No overflow because of numeric promotion
                            return c1 - c2;
                        }
                    }
                }
            }
            return n1 - n2;
        }
    }
