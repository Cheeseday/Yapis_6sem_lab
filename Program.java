import java.util.HashSet;
import java.util.Set;

public class Program {
    {
        public class Element {
            private String element;

            public Element(String element) {
                this.element = element;
            }

            @Override
            public String toString() {
                return element;
            }
        }

        public class Set {
            private java.util.Set<Element> set;

            public Set() {
                set = new HashSet<>();
            }

            public Set(java.util.Set<Element> set) {
                this.set = new HashSet<>(set);
            }

            public java.util.Set<Element> getSet() {
                return set;
            }

            @Override
            public String toString() {
                return set.toString();
            }

            public void add(Element elem) {
                set.add(elem);
            }

            public Element get(int index) {
                return set.get(index);
            }

            public void delete(Element elem) {
                set.delete(elem);
            }

            public void delete(int index) {
                set.delete(index);
            }

        }

        public static void main(String[] args) {
        try {
            new Program().start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

        private void start() throws Exception{Set set= new Set();Element firstElement = new Element("11");set.add(firstElement);for (Element elementOne:set.getSet()){System.out.println(elementOne);}}}
