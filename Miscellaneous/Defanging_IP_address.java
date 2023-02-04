package com.company.Miscellaneous;
// https://leetcode.com/problems/defanging-an-ip-address/
public class Defanging_IP_address {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defangIP(address));
    }

    static String defangIP(String address){
        return  address.replace(".","[.]");
    }
}
