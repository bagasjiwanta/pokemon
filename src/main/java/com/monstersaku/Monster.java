import java.util.List;
import java.util.ArrayList;

public class Monster {
    // Atribut
    private int id;
    private String nama;
    private List<ElementType> elementType;
    private Stats baseStats;
    private List<Move> moves;
    private StatusCondition statusCondition = StatusCondition.NONE;

    // Konstruktor
    public Monster(int id, String nama, ElementType elementTypes, Stats baseStats){
        this.id = id;
        this.nama = nama;
        this.elementTypes = elementType;
        this.baseStats = baseStats;
        this.moves = new ArrayList<Move>();
    }

    // All Getter Methods
    public String getName(){
        return this.nama;
    }

    public Stats getBaseStats(){
        return this.baseStats;
    }

    public List<ElementType> getElementType(){
        return this.elementTypes;
    }

    public void addMoves(Move move){
        this.moves.add(move);
    }

    public List<Move> getMoves(){
        return this.moves;
    }

    public StatusCondition getStatusCondition(){
        return this.statusCondition;
    }
     //All Setter Methods
    public void addElement(ElementType element){
        this.elementTypes.add(element);
    }

    public void setStats(Stats baseStats){
        this.baseStats = baseStats;
    }

    public void setMove(Move moves){
        this.moves = moves;
    }

    public void setCurrentStats(Stats currentStats) {
        this.currentStats = currentStats;
    }

    public boolean isMonsterAlive(){
        if (currentStats.getHealthPoint() != 0){
            return true;
        } else{
            return false;
        }
    }

    public void printMonsterAttributes() {
        System.out.println(this.id);
        System.out.println(this.nama);
        System.out.printf("Element: ");
        for (ElementType element : this.elementTypes){
            System.out.printf(element);
        }
        System.out.println("");
        System.out.println("HP: " + this.baseStats.getHealthPoint());
        System.out.println("Attack: " + this.baseStats.getAttack());
        System.out.println("Defense: " + this.baseStats.getDefense());
        System.out.println("Special Attack: " + this.baseStats.getSpecialAttack());
        System.out.println("Special Defense: " + this.baseStats.getSpecialDefense());
        System.out.println("Speed: " + this.baseStats.getSpeed());
    }
}