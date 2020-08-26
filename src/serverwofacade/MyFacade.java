/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverwofacade;

/**
 *
 * @author Jetnipit Morakot
 */
public class MyFacade {
    
    private static MyFacade MyFacadeObject = null;
    private MyFacade(){}
    private ScheduleServer scheduleServer = new ScheduleServer();
    public static MyFacade getMyFacadeObject()
    {
        if(MyFacadeObject == null)
        {MyFacadeObject = new MyFacade();}
        
        return MyFacadeObject;
    }
    
    public void StartServer()
    {
	scheduleServer.startBooting();
	scheduleServer.readSystemConfigFile();
	scheduleServer.init();
	scheduleServer.initializeContext();
	scheduleServer.initializeListeners();
	scheduleServer.createSystemObjects();
    }
    
    public  void StopServer()
    {
	scheduleServer.releaseProcesses();
	scheduleServer.destory();
	scheduleServer.destroySystemObjects();
	scheduleServer.destoryListeners();
	scheduleServer.destoryContext();
	scheduleServer.shutdown();
    }
    
}
