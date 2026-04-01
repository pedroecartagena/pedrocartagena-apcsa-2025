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
        solve(model.height(), 0, 2, 1);
        // Call the missing solve method (not this one)
    }

    // Create an overloaded solve(...) method
    public void solve(int height, int source, int destination, int spare)
    {
        if (height <= 0){
            return;
        }
        solve(height - 1, source, spare, destination);
        model.move(source, destination);
        solve(height - 1, spare, destination, source);  
    }

}
