## Mo, Sept 4, 2017

### KN: MATSim Scripts in Java, Injector syntax

AbstractModule:
* [?] addControlerListenerBinding(), addEventHandlerBinding(), … do we need the word “Binding” at the end
* [?] bindMobsim, binScoringFunctionFactory: bind, or set?
* ControlerDefaultsModule sets all the defaults. Have a look there to see defaults and how to change settings.
* [?] Controler Listener is null?
<pre>
2017-09-04 10:00:44,741  INFO AbstractController:133 ###################################################
2017-09-04 10:00:44,741  INFO AbstractController:134 ### ITERATION 0 BEGINS
2017-09-04 10:00:44,742  INFO ControlerListenerManagerImpl:145 calling notifyIterationStarts on org.matsim.analysis.LegHistogramListener
2017-09-04 10:00:44,743  INFO ControlerListenerManagerImpl:145 calling notifyIterationStarts on org.matsim.analysis.LinkStatsControlerListener
2017-09-04 10:00:44,743  INFO ControlerListenerManagerImpl:145 calling notifyIterationStarts on playground.mrieser.devmtg2017.IntroKai.XxxControlerListener
do something 2
2017-09-04 10:00:44,743  INFO ControlerListenerManagerImpl:145 calling notifyIterationStarts on org.matsim.core.replanning.ReplanningContextImpl
2017-09-04 10:00:44,743  INFO ControlerListenerManagerImpl:145 calling notifyIterationStarts on null
2017-09-04 10:00:44,743  INFO ControlerListenerManagerImpl:145 calling notifyIterationStarts on null
2017-09-04 10:00:44,744  INFO ControlerListenerManagerImpl:148 [it.0] all ControlerIterationStartsListeners called.
</pre>
* [?] Is there a way to control the order of event handlers or controler listeners?


### MZ: Infrastructure

* Source Code Repo
    * github
    * no more playgrounds
    * bundled contribs, unbundled contribs
    * [?] different groups for commit rights on github? currently every playground committer can commit to core as well
* Binary repositories (2)
    * for releases: BinTray
    * for Snapshots: JFrog, same accounts and permissions as on BinTray, linked to Jenkins
* Build servers (2)
    * Travis
        * tightly integrated with GitHub, only short-running tests
        * cannot leave artifacts back
    * Jenkins
* Issue Tracker (JIRA)
    * linked to GitHub, but not the other way round
* Internal Wiki (Confluence)
* Website
    * switch to static web site generation tool
    * [ ] talk to Billy about this.

### MZ: Dependency Injection

* If you can still do manual DI, do it. only use Guice if you need something as a building block.



### Performance optimizaitons

* Find some better/faster file formats for writing data, as our traditional data formats are too slow
    * JJ: Java serialization is faster


