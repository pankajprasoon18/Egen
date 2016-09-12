echo "Checking for Maven executable to build the program. "
hash mvn 2>/dev/null
if [ $? -eq 1 ]; then
    echo >&2 "Maven  not found. "
fi
echo "Maven Found!" 
echo "Checking for 'mongod' process"
pgrep mongod 2> /dev/null 
if [ $? -gt 0 ]; then 
    echo >&2 "Mongodb server not found.".
    exit;
fi 
echo "MongoDB service running. Now compiling Spring Boot Application Services"
mvn clean package
if [ $? -gt 0 ]; then 
	echo "error in this program.. , requirements should be met ";
	exit;
fi
#start service.
java -jar -Dbase.value=$1 target/egen-be-challenge-0.0.1-SNAPSHOT.jar
if [ $? -gt 0 ]; then 
        echo "error in this program.. , requirements should be met ";
        exit; 
fi
echo "Web application launched successfully.";
