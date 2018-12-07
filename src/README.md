# Generics

#### Motivation Behind Generics

String result = (String) list.get(0);
- Could potentially throw an error.

- Collections can contain any Object.
List list = new ArrayList();
list.add("A");
list.add("B");
list.add(1);

Generics stop runtime errors at compile time.

## Classes and Interfaces

#### Implement a Generic Type

    AgeComparator implements Comparator<Person>

#### Pass Up a Type Parameter

    Reverser<T> implements Comparator<T>

#### Type Bounds
    
    SortedPair<T extends Comparable<T>>

## Generics on Methods

    public static <T> T min(List<T> values, Comparator<T> comparator) {
    
Using <T> allows T to be referenced in the return type, parameters, and code.

## Wildcard Generics

#### Upper Bound

1. Declares an upper bound for the type parameter.

2. To get data out of the parameter.
    
3. Covariant

        - Arrays in java are covariant.
            - Sign a class to it's parent and put the elements in it.
            Partner[] partners = new Partner[2];
            Person[] persons = partners;
            - Problem with this:
                Employee[] employees = new Employee[2];
                Person[] persons = employees;
                persons[0] = new Partner("name", age); // will throw run time error.
        - Lists are not covariant
            - Problem with this:
                List<Partner> persons = new ArrayList<>();
                persons.add(donDraper);
                persons.add(bertCooper);
                saver.saveAll(persons);  // saveAll(List<Person> persons) so this fails now
    
    
    List<? extends Cls>
    
    This is a list of items of the same datatype that extend from Cls.

#### Lower Bound

1. Declares a lower bound for the type parameter.
    
2. To put data into the parameter
    
3. Contravariant


    List<? super Cls>
    
#### Unbounded
    
    List<?> => List<? extends Object>


## Rawtypes & Compatibility

#### Binary Compatibility for Generics
    
    - You can replace a legacy class file with a generic class file without changing or recompiling any client code.
        - Legacy code as in compiled before java had generics.
        - Client code as in code that makes use of that class.

#### Raw Types

    - Just a usage of a generic type with no generic parameters => compatible with legacy code.
    - List list = new ArrayList<>(); is NOT the same as List<Object> list = new ArrayList<>();

#### Erasure

    - How generics are implemented under the hood.
    
    - Translation at compile time, not runtime.
    
    - Three Steps
        - Erase Type Parameters
        - Add Casts
        - Add Bridge Methods
    
    Ex.
        
    List<String>, List<Integer>, List<List<Integer>> -> List
    
    List<String>[] -> List[]
    
    T without bounds -> Object
        - Check cast on methods that return T.
    
    T extends Foo -> Foo

##### The Implications of Erasure

* Overloads

List of String and List of Integer become just List<Object> at runtime.


        public void print(List<String> param) {
    
        }
    
        public void print(List<Integer> param) {
    
        }

* Checking the type of and Instance

Using a generic with instanceof here is illegal as the class does not really exist at runtime.

        public class InstanceOfExample<T> {
        
            @Override
            public boolean equals(Object obj) {
                // Illegal at runtime.
                if (obj instanceof InstanceOfExample<T>) {
                    return true;
                }
                return false;
            }
         }
         
You cannot extend anything that is throwable with generics.

        public class UncompilableException<T> throws Exception {}

* Performance

Forces us to use boxed types.

    Flatness: Int[] vs. Integer[]

    Int[] is stored sequentially in memory.

    Integer[] has references to the actually Integer objects in the heap stored sequentially.

Why is this a problem?

    - CPU runs a lot faster than memory
    - CPU cache is the only thing that is stopping CPU from being slowed down by main memory.
    - CPU caches can prefetch if they can predict where in memory the next element's going to be located.
    
Flat int array -> Easy to predict
Integer array -> Have references to Integers somewhere on the heap. Confuses cache prefetcher.
    
    Size: int vs. integer
    
    int
        - 4 bytes
    
    Integer
        - 4 bytes
        - Object Header: 8-16 bytes
        - Alignment: Allocate a multiple of 8 bytes
        - Pointer for arrays: 4 or 8 bytes
        - Worst case: 32 bytes (8x fatter)

Generics where generics are their own classes.

Pros: No downsides from erasure.
Cons: Not compatible with legacy code.

## Reflection & Lambdas

#### Class Literals

    Logger logger = injector.newInstance(Logger.class);


#### What types are Reflectable?

Types that are reified can be reflected.
    
    - Arrays ARE reifiable
    
        Integer[] myInts = {1,2,3,4};
        Number[] myNumber = myInts;
        myNumber[0] = 3.14; //attempt of heap pollution
    
    - At run time, Java knows that the array was instantiated as an array of integers
    - This array happens to be accessed through a reference of type Number[]
    
    - Generics are NOT reifiable (Class.getClass() does not tell you anything useful)
   
        List<Integer> myInts = newArrayList<Integer>();
        myInts.add(1);
        myInts.add(2);
        List<Number> myNums = myInts; //compiler error
        myNums.add(3.14); //heap polution
    
    - Due to a erasure, this would work at runtime. The java compiler stops this however.
    - At runtime, the true nature of the generic types are non determinable.
    
    Non Reifiable Types
        - Type Variables (T)
        - Parameterized Type with Parameters
            - ArrayList<String>
        - Parameterized Type with Bounds
            - List<? extends Number>, Consumer<? super String>
