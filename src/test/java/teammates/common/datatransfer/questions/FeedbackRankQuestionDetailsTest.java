package teammates.common.datatransfer.questions;

import org.testng.annotations.Test;

import teammates.test.BaseTestCase;

/**
 * SUT: {@link FeedbackRankQuestionDetails}.
 */
public class FeedbackRankQuestionDetailsTest extends BaseTestCase {
    @Test
    public void testValidateMinOptionsToBeRanked_sameValidValues_shouldReturnTrue() {
        int testValue = 100;
        FeedbackRankQuestionDetails feedbackRankQuestionDetails = new FeedbackRankOptionsQuestionDetails();
        feedbackRankQuestionDetails.setMinOptionsToBeRanked(testValue);
        assertEquals(feedbackRankQuestionDetails.minOptionsToBeRanked, testValue);
    }

    @Test
    public void testValidateMaxOptionsToBeRanked_sameValidValues_shouldReturnTrue() {
        int testValue = 100;
        FeedbackRankQuestionDetails feedbackRankQuestionDetails = new FeedbackRankOptionsQuestionDetails();
        feedbackRankQuestionDetails.setMaxOptionsToBeRanked(testValue);
        assertEquals(feedbackRankQuestionDetails.maxOptionsToBeRanked, testValue);
    }

    @Test
    public void testValidateDuplicatesAllowed_isAllowed_shouldReturnTrue() {
        FeedbackRankQuestionDetails feedbackRankQuestionDetails = new FeedbackRankOptionsQuestionDetails();
        feedbackRankQuestionDetails.setAreDuplicatesAllowed(true);
        assertEquals(feedbackRankQuestionDetails.areDuplicatesAllowed, true);
    }

    @Test
    public void testValidateDefaultValue_sameValues_shouldReturnTrue() {
        FeedbackRankQuestionDetails feedbackRankQuestionDetails = new FeedbackRankOptionsQuestionDetails();
        assertEquals(feedbackRankQuestionDetails.getMaxOptionsToBeRanked(), Integer.MIN_VALUE);
        assertEquals(feedbackRankQuestionDetails.getMinOptionsToBeRanked(), Integer.MIN_VALUE);
    }
}