CLASSPATH =
TESTCLASSPATH = $(CLASSPATH):Test/:Test/junit4.jar
JFLAGS = -g -cp $(TESTCLASSPATH)
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	StackComputer.java \
	StackException.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	rm *.class Test/*.class

test-build: classes Test/StackComputerTest.class Test/TestRunner.class

test-create: test-build
	java -cp $(TESTCLASSPATH) TestRunner StackComputerTest#testCreate

test-push: test-build
	java -cp $(TESTCLASSPATH) TestRunner StackComputerTest#testPush

test-pop: test-build
	java -cp $(TESTCLASSPATH) TestRunner StackComputerTest#testPop

test-add: test-build
	java -cp $(TESTCLASSPATH) TestRunner StackComputerTest#testAdd

test-sub: test-build
	java -cp $(TESTCLASSPATH) TestRunner StackComputerTest#testSub

test-mul: test-build
	java -cp $(TESTCLASSPATH) TestRunner StackComputerTest#testMul

test-div: test-build
	java -cp $(TESTCLASSPATH) TestRunner StackComputerTest#testDiv

test-general: test-build
	java -cp $(TESTCLASSPATH) TestRunner StackComputerTest#testGeneral

test-empty: test-build
	java -cp $(TESTCLASSPATH) TestRunner StackComputerTest#testEmpty

test: test-build
	java -cp $(TESTCLASSPATH) TestRunner StackComputerTest
