package extensions;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.MDC;

public class GetTestName implements BeforeEachCallback {


    @Override
    public void beforeEach(ExtensionContext context) throws Exception {

        final String fullyQualifiedTestName = context.getTestClass().get().getSimpleName() + "-"
                + context.getTestMethod().get().getName()
                + "-"
                + context.getDisplayName();

        MDC.put("methodName", fullyQualifiedTestName);

        final String fullMethodName = context.getTestClass().get().getSimpleName() + "-"
                + context.getTestMethod().get().getName();
        MDC.put("folderName", fullMethodName);

/*        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  ---> It is possible of using only one discriminator in shifting appender so implementing this with folderName won't work
        final String timeForLogback = timestamp.toString();
        MDC.put("timestampLogback", timeForLogback);*/



    }

}

