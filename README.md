##reverse-benchmark

Compares performance among different implementations of string reverse in
varying languages. For each language provided, the program should be called
with the number of iterations and the method version to use for the benchmark.
The program outputs the number of milliseconds it took to run the iterations.

All programs use the standard Lorem Ipsum paragraph text.

###Method Versions

####Version 1: Array manipulation

    function string reverse(input) {
        array1 = split input into characters
        array2 = reverse array1
        return the joined elements of array2 as a string
    }

####Version 2: String concatentation

    function string reverse(input) {
        output = an empty string
        for char = each character of input from end to beginning
            concatenate char to output
        return output
    }

###Language Benchmarks

####Java

    javac Reverse.java
    java Reverse <iterations> <version>

####Node/JavaScript

    node ./reverse.js <iterations> <version>

####Perl

    perl ./reverse.pl <iterations> <version>
