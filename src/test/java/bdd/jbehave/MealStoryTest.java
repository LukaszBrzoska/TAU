package bdd.jbehave;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.jupiter.api.Test;

public class MealStoryTest extends JUnitStory {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                //here to find the stories
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                //console and txt reporting
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(StoryReporterBuilder.Format.CONSOLE, StoryReporterBuilder.Format.TXT));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new MealStoryTest());
    }

    @Test
    public void run()  {
        super.run();
    }
}
