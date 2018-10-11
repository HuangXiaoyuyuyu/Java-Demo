package SpringBoot_MybatisPlus.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 公共字段自动填充
 * createDate 创建时间
 * updateDate 修改时间
 */
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("create_date", new Date(), metaObject);
        setFieldValByName("update_date", new Date(), metaObject);
        setFieldValByName("del_flag",0,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("update_date", new Date(), metaObject);
    }
}
