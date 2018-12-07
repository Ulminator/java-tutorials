package com.generics.reflection.reflectingGenerics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReifiableExamples {

    public static class StringList extends ArrayList<String> {

    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Class<?> arrayList = strings.getClass();

        final TypeVariable<? extends Class<?>>[] typeVariables = arrayList.getTypeParameters();
        System.out.println(Arrays.toString(typeVariables));  // Can introspect what type parameters a class has.

        System.out.println(arrayList);
        System.out.println(arrayList.toGenericString());  // Get the fully qualifies generic information.

        // With a subclass extending a generic class, it is possible to see what that generic type is.
        final ParameterizedType arrayListOfString = (ParameterizedType) StringList.class.getGenericSuperclass();
        System.out.println(Arrays.toString(arrayListOfString.getActualTypeArguments()));
    }
}
