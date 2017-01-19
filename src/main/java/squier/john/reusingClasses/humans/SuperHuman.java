package squier.john.reusingClasses.humans;

/**
 * Created by johnsquier on 1/18/17.
 */
public class SuperHuman extends Human {
    Boolean isGood;
    String heroName;
    String superAbility;

    public SuperHuman() {
        super();
        isGood = true;
        heroName = "default";
        superAbility = "default";
    }

    public SuperHuman(String name, Integer age, Genders gender, String occupation, String address,
                      Boolean isGood, String heroName, String superAbility) {
        super(name, age, gender, occupation, address);
        this.isGood = isGood;
        this.heroName = heroName;
        this.superAbility = superAbility;
    }

    public Boolean getIsGood() { return isGood; }
    public void setIsGood(Boolean isGood) { this.isGood = isGood; }

    public String getHeroName() { return heroName; }
    public void setHeroName(String heroName) { this.heroName = heroName; }

    public String getSuperAbility() { return superAbility; }
    public void setSuperAbility(String superAbility) { this.superAbility = superAbility; }

    @Override
    public void printInformation() {
        super.printInformation();
        System.out.printf("isGood: %s\nheroName: %s\nsuperAbility: %s\n",
                isGood.toString(), heroName, superAbility);
    }
}
