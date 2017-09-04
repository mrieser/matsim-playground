package playground.mrieser.devmtg2017;

import org.matsim.api.core.v01.Scenario;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.AbstractModule;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.events.IterationStartsEvent;
import org.matsim.core.controler.listener.IterationStartsListener;
import org.matsim.core.scenario.ScenarioUtils;

import javax.inject.Inject;
import java.net.MalformedURLException;

public class IntroKai {

	public static void main(String[] args) throws MalformedURLException {

//		URL filename = new URL("file:///data/repositories/git-clone/matsim/examples/scenarios/equil/config.xml");
//		Config config = ConfigUtils.loadConfig(filename);
		Config config = ConfigUtils.createConfig();

		// modify config if needed
		config.controler().setLastIteration(5);

		// -------------------

		Scenario scenario = ScenarioUtils.createScenario(config);

		// modify scenario if needed

		// ----------------

		Controler controler = new Controler(scenario);

		// modify controler if needed:
		controler.addOverridingModule(new AbstractModule() {
			@Override
			public void install() {
				this.bind(XxxInterface.class).to(XxxImpl2.class);
				this.addControlerListenerBinding().to(XxxControlerListener.class);
			}
		});

		controler.run();
	}

	interface XxxInterface {
		void doSomething();
	}

	static class XxxImpl implements XxxInterface {
		@Inject Scenario sc;
		@Inject
		EventsManager events;
		// no constructor (=default constructor)
		// unclear if default constructor can be used?


		XxxImpl() {
			System.out.println("c'tor 1");
			System.out.println("sc = " + this.sc);
			System.out.println("events≠ = " + this.events);
			// problem: sc and events are still null! So we can't do anything with it, see XxxImpl2
		}

		@Override
		public void doSomething() {
			System.out.println("do something");
		}
	}

	// alternative:

	static class XxxImpl2 implements XxxInterface {
		Scenario sc;
		EventsManager events;

		@Inject
		XxxImpl2 (Scenario sc, EventsManager events) { // should be package protected
			this.sc = sc;
			this.events = events;
			System.out.println("c'tor 2");
			System.out.println("sc = " + this.sc);
			System.out.println("events≠ = " + this.events);
		}

		@Override
		public void doSomething() {
			System.out.println("do something 2");
		}
	}

	static class XxxControlerListener implements IterationStartsListener {

		@Inject
		XxxInterface xxx;

		@Override
		public void notifyIterationStarts(IterationStartsEvent event) {
			xxx.doSomething();;
		}
	}

}
