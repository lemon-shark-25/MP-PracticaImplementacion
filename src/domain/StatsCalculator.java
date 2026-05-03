package domain;

public class StatsCalculator {
    private Algorithm damageStrategy;
    private Algorithm defenseStrategy;
    
    public StatsCalculator() {
        this.damageStrategy = new DamageAlgorithm();
        this.defenseStrategy = new DefenceAlgorithm();
    }

    public int calculatedamage(GameCharacter c) {
        if (damageStrategy == null) {
            throw new IllegalStateException("Damage strategy is not configured.");
        }
        return damageStrategy.execute(c);
    }

    public int calculatedefense(GameCharacter c) {
        if (defenseStrategy == null) {
            throw new IllegalStateException("Defense strategy is not configured.");
        }
        return defenseStrategy.execute(c);
    }

    public void setdamagestrategy(Algorithm a) {
        this.damageStrategy = a;
    }

    public void setdefencestrategy(Algorithm a) {
        this.defenseStrategy = a;
    }
}

