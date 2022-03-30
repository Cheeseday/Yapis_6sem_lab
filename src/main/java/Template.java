public class Template {
    public static final String PROGRAM = "import java.util.Set;\n " +
            "import java.util.HashSet;\n" +
            "\n" +
            "public class Program {\n" +
            "    public class Element {\n" +
            "        private String element;\n" +
            "\n" +
            "        public Element(String element) {\n" +
            "            this.element = element;\n" +
            "        }\n" +
            "\n" +
            "        @Override\n" +
            "        public String toString() {\n" +
            "            return element;\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    public class Set {\n" +
            "        private java.util.Set<Element> set;\n" +
            "\n" +
            "        public Set() {\n" +
            "            set = new HashSet<>();\n" +
            "        }\n" +
            "\n" +
            "        public Set(java.util.Set<Element> set) {\n" +
            "            this.set = new HashSet<>(set);\n" +
            "        }\n" +
            "\n" +
            "        public java.util.Set<Element> getSet() {\n" +
            "            return set;\n" +
            "        }\n" +
            "\n" +
            "        @Override\n" +
            "        public String toString() {\n" +
            "            return set.toString();\n" +
            "        }\n" +
            "\n" +
            "        public void add(Element element) {\n" +
            "            set.add(element);\n" +
            "        }\n" +
            "\n" +
            "        public Element get(int index) {\n" +
            "            return set.get(index);\n" +
            "        }\n" +
            "\n" +
            "        public void delete(Element element) {\n" +
            "            set.delete(element);\n" +
            "        }\n" +
            "\n" +
            "        public void delete(int index) {\n" +
            "            set.delete(index);\n" +
            "        }\n" +
            "\n" +
            "    public static void main(String[] args) {\n" +
            "        try {\n" +
            "            new Program().start();\n" +
            "        } catch (Exception e) {\n" +
            "            e.printStackTrace();\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    private void start() throws Exception";
}
