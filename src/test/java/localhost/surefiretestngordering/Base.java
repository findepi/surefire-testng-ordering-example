package localhost.surefiretestngordering;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;
import static java.lang.Thread.currentThread;

public abstract class Base
{
    private static final AtomicInteger resources = new AtomicInteger();

    @BeforeClass
    public void setupAllocateResources()
    {
        logMethod("Base", "setupAllocateResources", "resources allocated: %s", resources.incrementAndGet());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownReleaseResources()
    {
        logMethod("Base", "tearDownReleaseResources", "resources allocated: %s", resources.decrementAndGet());
    }

    @Test
    public void test1()
            throws Exception
    {
//        logMethod("Base", "test1");
        Thread.sleep(ThreadLocalRandom.current().nextInt(3));
    }

    @Test
    public void test2()
            throws Exception
    {
//        logMethod("Base", "test2");
        Thread.sleep(ThreadLocalRandom.current().nextInt(3));
    }

    @Test
    public void test3()
            throws Exception
    {
//        logMethod("Base", "test3");
        Thread.sleep(ThreadLocalRandom.current().nextInt(3));
    }

    protected void logMethod(String className, String methodName)
    {
        logMethod(className, methodName, "");
    }

    protected void logMethod(String className, String methodName, String message, Object... args)
    {
        if (!message.isEmpty()) {
            message = ": " + format(message, args);
        }
        System.out.println(format("[thread %s] %s / %s.%s%s", currentThread().getId(), getClass().getSimpleName(), className, methodName, message));
    }
}
