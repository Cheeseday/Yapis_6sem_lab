import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Variable {
    private static final Variable INSTANCE = new Variable();
    private Variable() {}
    public static Variable getInstance() { return INSTANCE; }

    private final Set<String> setVarSet = new HashSet<>();
    private final Set<String> elementVarSet = new HashSet<>();
    private final List<Set<String>> stack = new ArrayList<>();
    private final Set<String> functionSet = new HashSet<>();

    public void incrementStack() {
        Set<String> set = new HashSet<>();
        stack.add(set);
    }
    public void decrementStack() {
        for (String s : stack.get(stack.size() - 1)) {
            setVarSet.remove(s);
            elementVarSet.remove(s);
        }
        stack.remove(stack.size() - 1);
    }
    public void addElement(String var) {
        stack.get(stack.size() - 1).add(var);
        elementVarSet.add(var);
    }
    public void addSet(String var) {
        stack.get(stack.size() - 1).add(var);
        setVarSet.add(var);
    }
    public boolean containsSet(String var) {
        return setVarSet.contains(var);
    }
    public boolean containsElement(String var) {
        return elementVarSet.contains(var);
    }
    public void addFunction(String var) {
        functionSet.add(var);
    }
    public boolean containsFunction(String var) {
        return functionSet.contains(var);
    }
}