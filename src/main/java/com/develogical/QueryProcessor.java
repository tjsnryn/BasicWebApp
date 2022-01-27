package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("tejas")) {
            return "Tejas Narayan is a student at Imperial College London";
        }

        if (query.toLowerCase().contains("imperial")) {
            return "Imperial College is a university in London";
        }

        if (query.toLowerCase().contains("what is your name")) {
            return "tn";
        }

        if (query.toLowerCase().contains("which of the following numbers is the largest:")) {
            String[] numbers_str = query.split(":")[1].split(",");
            int out = 0;
            for (String s: numbers_str) {
                try {
                    out = Math.max(Integer.parseInt(s.trim()), out);
                }
                catch (Exception e) {
                    System.out.println(e);
                }

            }

            return Integer.toString(out);
        }

        if (query.toLowerCase().contains("which of the following numbers is both a quare and a cube:")) {
            String[] numbers_str = query.split(":")[1].split(",");
            int out = 0;
            for (String s: numbers_str) {
                try {
                    int n = Integer.parseInt(s);

                    if (n == Math.floor(Math.sqrt(n)) * Math.floor(Math.sqrt(n))) {
                        if (n == Math.floor(Math.cbrt(n)) * Math.floor(Math.cbrt(n)) * Math.floor(Math.cbrt(n))) {
                            out = n;
                        } 
                    }
                }
                catch (Exception e) {
                    System.out.println(e);
                }

            }

            return Integer.toString(out);
        }

        if (query.toLowerCase().contains("plus") && query.toLowerCase().contains("what is")) {
            String[] matches = query.split(" ");
            try {
                return Integer.toString(Integer.parseInt(matches[3]) + Integer.parseInt(matches[5]));
            } catch (Exception e) {
                System.out.println(e);
            }
             
        }

        if (query.toLowerCase().contains("multiplied by") && query.toLowerCase().contains("what is")) {
            String[] matches = query.split(" ");
            try {
                return Integer.toString(Integer.parseInt(matches[3]) + Integer.parseInt(matches[6]));
            } catch (Exception e) {
                System.out.println(e);
            }
             
        }

        return "";
    }
}
