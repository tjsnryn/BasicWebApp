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
            System.out.println(query);
            String[] numbers_str = query.split(":")[2].split(",");
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

        if (query.toLowerCase().contains("which of the following numbers is both a square and a cube:")) {
            String[] numbers_str = query.split(":")[2].split(",");
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
                System.out.println(matches);
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

        if (query.toLowerCase().contains("minus") && query.toLowerCase().contains("what is")) {
            String[] matches = query.split(" ");
            try {
                return Integer.toString(Integer.parseInt(matches[3]) - Integer.parseInt(matches[5]));
            } catch (Exception e) {
                System.out.println(e);
            }
             
        }

        if (query.toLowerCase().contains("what colour is a banana")) {
            return "yellow";
        }

        if (query.toLowerCase().contains("which year was theresa may first elected as the prime minister of great britain")) {
            return "2016";
        }

        if (query.toLowerCase().contains("which city is the eiffel tower in")) {
            return "Paris";
        }

        if (query.toLowerCase().contains("number in the fibonacci sequence")) {
            int out = 1;

            try {
                String s = query.split(" ")[4];
                int n = Integer.parseInt(s.substring(0, s.length() - 2));
                out = 1;
                int prev = 1;
                for (int i = 1; i < n; i++) {
                    int tmp = out;
                    out += prev;
                    prev = tmp;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            return Integer.toString(out);
        }

        return "";
    }
}
