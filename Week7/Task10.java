import java.util.*;

class ThroneInheritance {

    private class Person {
        String name;
        boolean alive;
        List<Person> children;

        Person(String name) {
            this.name = name;
            this.alive = true;
            this.children = new ArrayList<>();
        }
    }

    private Map<String, Person> map;
    private Person king;

    public ThroneInheritance(String kingName) {
        king = new Person(kingName);
        map = new HashMap<>();
        map.put(kingName, king);
    }
    
    public void birth(String parentName, String childName) {
        Person parent = map.get(parentName);
        Person child = new Person(childName);
        parent.children.add(child);
        map.put(childName, child);
    }
    
    public void death(String name) {
        map.get(name).alive = false;
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        preorder(king, order);
        return order;
    }

    private void preorder(Person p, List<String> order) {
        if (p.alive) order.add(p.name);
        for (Person child : p.children) {
            preorder(child, order);
        }
    }
}