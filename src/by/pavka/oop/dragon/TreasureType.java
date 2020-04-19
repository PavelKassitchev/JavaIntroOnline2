package by.pavka.oop.dragon;

import java.util.ArrayList;
import java.util.List;

import static by.pavka.oop.dragon.Nation.*;

public enum TreasureType {
    DIAMOND(GERMAN, 8, 40), GOLD(GERMAN, 5, 30), SILVER(GERMAN, 4, 12),
    ALCOHOL(RUSSIAN, 12, 25), RED_CAVIAR(RUSSIAN, 4, 10), BLACK_CAVIAR(RUSSIAN, 7, 18),
    PORCELAIN(CHINESE, 4, 12), SILK(CHINESE, 2, 7), PEARL(CHINESE, 10, 40);

    public final Nation NATION;
    public final int MIN_PRICE;
    public final int MAX_PRICE;

    private TreasureType(Nation nation, int minPrice, int maxPrice) {
        NATION = nation;
        MIN_PRICE = minPrice;
        MAX_PRICE = maxPrice;
    }

    public static List<TreasureType> getNationalTreasureTypes(Nation nation) {
        List<TreasureType> types = new ArrayList<>();
        for(TreasureType t: TreasureType.values()) {
            if(t.NATION == nation) {
                types.add(t);
            }
        }
        return types;
    }
}
