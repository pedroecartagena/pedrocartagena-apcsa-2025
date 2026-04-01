package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        solver(model.height(), 0, 2, 1);
        // Call the missing solve method (not this one)
    }

    // Create an overloaded solve(...) method
    public void solve(int height, int source, int destination, int spare)
    {
        
    }

}
