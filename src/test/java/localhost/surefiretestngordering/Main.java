package localhost.surefiretestngordering;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static class RunWithSuiteFile
    {
        public static void main(String[] args)
        {
            TestNG testng = new TestNG(true);
            testng.setTestSuites(List.of("aaa.xml"));
            testng.run();
        }
    }

    public static class RunLikeSurefire
    {
        public static void main(String[] args)
        {
            TestNG testng = new TestNG(true);
            XmlSuite xmlSuite = new XmlSuite();
            xmlSuite.setName("Surefire suite");
            xmlSuite.setParallel("methods");
            xmlSuite.setThreadCount(2);
            XmlTest xmlTest = new XmlTest(xmlSuite);
            xmlTest.setName("Surefire test");
            xmlTest.setXmlClasses(List.of(
                    new XmlClass("localhost.surefiretestngordering.TestClass1"),
                    new XmlClass("localhost.surefiretestngordering.TestClass2"),
                    new XmlClass("localhost.surefiretestngordering.TestClass3"),
                    new XmlClass("localhost.surefiretestngordering.TestClass4")));
//            xmlTest.setGroupByInstances(false);
            testng.setXmlSuites(List.of(xmlSuite));
            testng.run();
        }
    }
}
