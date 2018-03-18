package com.phinmaregistraronlinecourse.adapter;

/**
 * Created by Manipon on 03/08/2018.
 */

public class AchievementData {
    private int id;
    private String module1,module2,module3,module4,module5,module6,module7;

    public AchievementData(int id, String module1, String module2, String module3, String module4, String module5, String module6, String module7) {
        this.id = id;
        this.module1 = module1;
        this.module2 = module2;
        this.module3 = module3;
        this.module4 = module4;
        this.module5 = module5;
        this.module6 = module6;
        this.module7 = module7;

    }

    public int getScoreId() {
        return id;
    }
    public String getScoreModule1() {
        return module1;
    }
    public String getScoreModule2() {
        return module2;
    }
    public String getScoreModule3() {
        return module3;
    }
    public String getScoreModule4() {
        return module4;
    }
    public String getScoreModule5() {
        return module5;
    }
    public String getScoreModule6() {
        return module6;
    }
    public String getScoreModule7() {
        return module7;
    }

}
