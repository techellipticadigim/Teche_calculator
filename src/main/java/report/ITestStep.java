package report;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

public class ITestStep implements ConcurrentEventListener {

    public EventHandler<TestStepStarted> starthandler = this::stepStart;
    public EventHandler<TestStepFinished> finishHandler = this::stepFinish;
    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
    eventPublisher.registerHandlerFor(TestStepStarted.class, starthandler);
    eventPublisher.registerHandlerFor(TestStepFinished.class,finishHandler);

    }

    private void stepStart(TestStepStarted teststep){
        if(teststep.getTestStep() != null && teststep.getTestStep() instanceof PickleStepTestStep){
            PickleStepTestStep step = (PickleStepTestStep)teststep.getTestStep();
        }
    }

    private void stepFinish(TestStepFinished teststep){
        if(teststep.getTestStep() != null && teststep.getTestStep() instanceof PickleStepTestStep){
            PickleStepTestStep step = (PickleStepTestStep)teststep.getTestStep();
            System.out.println(teststep.getResult().getStatus());
        }
    }


}
