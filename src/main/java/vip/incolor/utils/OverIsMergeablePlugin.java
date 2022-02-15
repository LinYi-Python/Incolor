package vip.incolor.utils;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 检查是否已经逆向工程输出过代码和配置文件
 * 如果有，则不完全替换掉上述文件，而是增量更新
 * 如果没有，则完全新增上述文件
 */
public class OverIsMergeablePlugin extends PluginAdapter {
	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
		try {
			Field field = sqlMap.getClass().getDeclaredField("isMergeable");
			field.setAccessible(true);
			field.setBoolean(sqlMap, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
