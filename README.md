# Java Matrix multiplication
## IPL Programming Competition
This is a fast concurrent matrix multiplication algorithm implemented for the *IPL Programming Competition* at Imperial College London.
## Performance
Here's a comparison of each different approach adopted during the design of the algorithm*:
- Simple Multiplication: [1.511, 1.658] (s/op)
- Concurrent Rows: [0.393, 0.407] (s/op)
- Hybrid Algorithm: [0.393, 0.405] (s/op)
- Temporal Locality: [0.209, 0.221] (s/op)

*assuming normal distribution

The test were run on a machine equipped with a Intel i7-6700 (4 physical cores, 8 virtual cores) and 16GB of RAM

## Testing
A benchmark is provided in the [target](target) directory for testing purposes.

To run the benchmark you will need maven.

Type the following commands:

``mvn clean install``

``java -jar target/benchmarks.jar -f 1 -to 120s -foe true -tu s -wi 10 -i 10``
