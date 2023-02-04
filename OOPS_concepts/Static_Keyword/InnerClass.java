package com.company.OOPS_concepts.Static_Keyword;

public class InnerClass {
    static class Test{
        String name;
        public Test(String name){
            this.name = name;
        }
        // without the static keyword class Test is dependent on the object of InnerClass
        // with the static keyword class Test is dependent on the InnerClass and not its objects
    }

    public static void main(String[] args) {
        Test a = new Test("ABC");
        Test b = new Test("CDE");
    }
}
