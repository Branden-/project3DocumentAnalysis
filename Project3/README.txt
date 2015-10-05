1.  Who is in your group?

  Anh Ho and Branden Andersen

2.  How long did the project take?

    The project took approximately thirty hours to complete. Anh put in
    about 17 hours and Branden put in the other thirteen hours.

3.  Before you started, which data structure did you expect would be the
    fastest?

    We both expected the hash table to be the fastest data structure
    because of how it is basically an array using keys.

4.  Which data structure is the fastest? Why were you right or wrong?

    The hash table was the fastest data structure and therefore we were
    right in our expectations.

5.  In general, which DataCounter dictionary implementation was "better":
    trees or hash tables? Note that you will need to define "better" (
    ease of coding, ease of debugging, memory usage, disk access patterns,
    runtime for average input, runtime for all input, etc).

    Before explaining which DataCounter dictionary implementation was
    better, we will define what we mean by better. The primary objective
    metric we measured was execution time and memory usage. Memory
    usage was determined by using a plugin called Memory Analyzer, which
    took a dump file and displayed in pie chart how much memory was being
    used and by what object. Execution time was measured using the method
    System.nanoTime() and was measured from when the objects were created
    to the end where all the data was printed. Our subjective
    metric was how easily each data structure on scale of 1 to 10, where
    1 is the easiest data structure to code (better) and 10 is the hardest
    data structure to code (worse). Our assumption was that there is no
    hard disk access, and all items are in memory.

    With respect to memory usage, the hash table used slight more memory on
    average. The memory usage for a binary search tree and an AVL tree
    was basically the same. When memory usage is considered for a standard
    PC, the difference in memory usage is negligible. If memory usage is
    a major restriction such as on a micro controller, a binary search tree
    or AVL tree implementation would be a a better data structure.

    When considering execution time, a hash table is hands down the fastest
    data structure. Our timing was measured in seconds, and even with large files
    a hash table was able to perform the operations in less than a second. The
    next fastest data structure was the binary search tree (usually on the order
    of three to five sceonds). The slowest data
    structure by several hundreds of seconds (on the order of minutes slower)
    was the AVL tree. If execution time is the primary concern, the best
    data structure to use would be a hash table.

    As for coding difficulty, the data structure that got the highest rating
    for being the most difficult to code is the AVL tree (score of 10). The rotations
    and the updating of the node heights were the most difficult to code.
    The easiest to code was the binary search tree (score of 1) since it was
    relatively easy to conceptualize and most of the coding could be solved
    with very simple recursion. The hash table data structure got a score of
    5 for coding difficulty. Figuring out what hash to use and implementing
    the linked list for collision were the most difficult aspects of the coding
    but  were still far easier to code than the rotations of the AVL tree.

   Considering the previous ratings, the better DataCounter dictionary
   implementation was the hash table. The hash table is relatively easy
   to code, runs very fast, and its memory usage is not much more on average
   than the binary tree or the AVL tree.

6.  Are there cases in which a particular data structure performs really
    well or badly in the correlator? Enumerate the cases for each data
    structure.

    For very large amounts of data, the AVL tree performed very badly
    compared with any of the other data structures. The hash table
    performed consistently well with regards to speed for large or small
    data sets. The binary search tree data structure was fast but never as fast
    as the hash table, and began to take couples of seconds when running
    very large data sets are opposed to less than a second for a hash
    table.

7.  Give a one or two paragraph explanation of whether or not you think
    Bacon wrote Shakespeare's plays based on the data you collected. No
    fancy statistical analysis here (formal analysis comes later); keep
    it fun and simple.

    When examining the different works of Shakespeare against other works
    of Shakespeare, the Euclidean frequency distance is zero. When examining
    the complete works of Shakespeare against Bacon's works, the Euclidean
    frequency distance is 0.0349. From this we can conclude that Shakespeare
    was the actual author of the works attributed to him and not Francis
    Bacon.


8.  Writeup your benchmarks (this is long). Your mission is to convince
    us that your benchmark makes sense and that we should be interested
    in it if we are trying to ascertain which data structure is better
    suited for your input. You wil need to answer at least the following
    (all formal analysis should answer something similar):
    * What are you measuring?
    * What is the definition of "better" given your measurement?
    * Why is the measurment interesting in determining which is the
      superior algorithm for this project?
    * What was your method of benchmarking?
    * What were the sources of errors?
    * What were your results?
    * How did you interpret your results?
    * What were your conclusions?
    * Are there any interesting directions for future study?

9.  What did you enjoy about this assignment? What did you hate? Could we
    have done anything better?
