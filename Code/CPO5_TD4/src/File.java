
import java.util.Iterator;

public class File<T> implemments Iterable<T>{

    Pile<T> un, deux;
    
    public File(){
        un = new Pile<T>();
        deux = new Pile<T>();
    }
    
    public void add(T e){
        deux.add(e);
    }
    
    public T defile(){
        if(un.hautDePile == null){
            while(deux.hautDePile != null)
                un.add(deux.depiler());
        }
        return un.depiler();
    }
    
    Iterator<T> iterator(){
        return new Iterator<T>() {
            Iterator iter1 = un.iterator();
            Iterator iter2 = deux.iterator();
            
            public boolean hasNext(){
                return iter1.hasNext() || iter2.hasNext();
            }
            
            public T next() {
                if(iter1.hasNext())
                    return (T) iter1.next();
                else 
                    return (T) iter2.next();
            }
            
            public void remove(){
                thow UnsupportedOperationException;
            }
        };
    }
}
