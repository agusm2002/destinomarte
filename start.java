import greenfoot.*;  


public class start extends World
{
    
    public start()
    {    
        super(670, 500, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        easy easy = new easy();
        addObject(easy,337,273);
        medium medium = new medium();
        addObject(medium,337,348);
        hard hard = new hard();
        addObject(hard,337,413);
    }
    
}
