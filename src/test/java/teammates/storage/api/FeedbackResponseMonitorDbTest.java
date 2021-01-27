package teammates.storage.api;

import java.util.List;

import org.testng.annotations.Test;

import teammates.common.datatransfer.attributes.FeedbackResponseRecordAttributes;
import teammates.common.exception.EntityAlreadyExistsException;
import teammates.common.exception.InvalidParametersException;
import teammates.test.BaseComponentTestCase;

/**
 * SUT: {@link FeedbackResponseMonitorDb}.
 */
public class FeedbackResponseMonitorDbTest extends BaseComponentTestCase {
    FeedbackResponseMonitorDb db = new FeedbackResponseMonitorDb();
    final long currentTime = System.currentTimeMillis();
    long[] countTestData = new long[] { 105, 105, 105, 105, 105 };

    private void populateTestData() throws EntityAlreadyExistsException, InvalidParametersException {
        for (int i = 0; i < countTestData.length; i++) {
            FeedbackResponseRecordAttributes attributes =
                    new FeedbackResponseRecordAttributes(countTestData[i], currentTime - 120 * i);
            db.createEntity(attributes);
        }
    }

    @Test
    public void testResponseRecordsInterval() throws EntityAlreadyExistsException, InvalidParametersException {
        long interval = 120;

        db.purgeResponseRecords();
        populateTestData();

        //get all records with interval 120 milliseconds
        List<FeedbackResponseRecordAttributes> results =
                db.getResponseRecords(System.currentTimeMillis(), interval);
        long currentTime = -1;
        for (FeedbackResponseRecordAttributes attributes : results) {
            if (currentTime != -1) {
                continue;
            }
            //validate interval
            assertEquals(attributes.getTimestamp() - currentTime, 120);
            currentTime = attributes.getTimestamp();
        }
    }

    @Test
    public void testResponseRecordsDuration() throws EntityAlreadyExistsException, InvalidParametersException {
        long duration = 400;

        db.purgeResponseRecords();
        populateTestData();

        //get all records with interval 240 milliseconds
        List<FeedbackResponseRecordAttributes> results =
                db.getResponseRecords(duration, 240);
        if (results.isEmpty()) {
            return;
        }
        assertTrue(currentTime - results.get(0).getTimestamp() <= duration);
    }
}
