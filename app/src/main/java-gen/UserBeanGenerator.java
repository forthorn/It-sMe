import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

import java.io.IOException;

/**
 * Created by: Forthorn
 * Date: 2016-07-22.
 * Description:
 * GreenDao工具生成Bean类，用于生成User类
 */
public class UserBeanGenerator {
    public static void main(String[] args){
        int version =1;
        String defaultPackage = "com.forthorn.gen.bean";
        String defaultPackageDao = "com.forthorn.gen.dao";
        Schema schema = new Schema(version,defaultPackage);
        schema.setDefaultJavaPackageDao(defaultPackageDao);
        addEntity(schema);
        String outDir  = "../It'sMe/app/src/main/java-gen";
        try {
            new DaoGenerator().generateAll(schema,outDir);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void addEntity(Schema schema) {
        Entity entity = schema.addEntity("User");
        entity.setTableName("User");
        entity.addIdProperty().autoincrement();
        entity.addIntProperty("uid").notNull();
        entity.addStringProperty("nickname").notNull();
        entity.addStringProperty("password").notNull();
        entity.addStringProperty("gender");
        entity.addIntProperty("age");
        entity.addStringProperty("birthday");
        entity.addStringProperty("email");
        entity.addStringProperty("address");
        entity.addStringProperty("tel");
    }
}
