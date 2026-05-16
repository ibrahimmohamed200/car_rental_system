
package carrentalsystemproject;


public class CarRentalSystemProject {

    
    public static void main(String[] args) {
        DBConncetion db = new DBConncetion();
        db.connectOnlineDB();
        Tables t = new Tables();
        t.CreateTables();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }
    
}
