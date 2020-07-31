# Coherence tools
Utility tools for Oracle Coherence

## Description
Utility tools for Oracle Coherence includes following components

### Distributed Processing Tools  
Tools to run distributed processing task in multi Coherence member processes exclusively. This component can handle dynamic changes in number of processing members, which provides following functions
* FIFO distributed processor: Consumer/Function implementation for distributed processing as first in, first out
* Hash modulo filter: Filter to get target entries by hashCode modulo of a key/value object or a field of them

Go to [distributed-processing-tools](distributed-processing-tools)

### Write Behind Tools
Tools for write behind queue, which provides following functions
* Get current write behind queue size in the cluster
* Clear retaining data in write behind queue in the cluster

Go to [write-behind-tools](write-behind-tools)

### Spring MyBatis CacheStore  
CacheStore implementation integrated with Spring and MyBatis framework  
Go to [spring-mybatis-cachestore](spring-mybatis-cachestore)

### Multi Clusters Proxy
Tools for extend proxy to connect multiple clusters including SelectableCacheFactory to operate multiple named caches in several clusters  
Go to [multi-clusters-proxy](multi-clusters-proxy)

## Requirements
These tools require Oracle Coherence.

### Using Oracle Coherence Community Edition
All builtin test modules are using [Oracle Coherence Community Edition](https://coherence.community). All required modules are packaged as Maven project.

### Using Oracle Coherence Non-Community Edition
If you would like to use non-community edition, you need to install Oracle Coherence. 
See [Oracle Coherence](https://www.oracle.com/middleware/technologies/coherence.html) for more details (Not for development purposes, Oracle Coherence license is needed).

1. Download Coherence Stand-Alone Install from [Oracle Technology Network](https://www.oracle.com/middleware/technologies/coherence-downloads.html)

2. Run installer as following command with your Coherence version
```sh
$ java -jar fmw_12.2.1.0.0_coherence.jar
```

3. Register Coherence to local Maven repository
```sh
$ mvn -DpomFile=$ORACLE_HOME/oracle_common/plugins/maven/com/oracle/maven/oracle-maven-sync/12.2.1/oracle-maven-sync-12.2.1.pom -Dfile=$ORACLE_HOME/oracle_common/plugins/maven/com/oracle/maven/oracle-maven-sync/12.2.1/oracle-maven-sync-12.2.1.jar install:install-file
$ mvn -Doracle-maven-sync.oracleHome=$ORACLE_HOME -Doracle-maven-sync.testOnly=false com.oracle.maven:oracle-maven-sync:12.2.1-0-0:push
```

## License
[Apache License](LICENSE)
