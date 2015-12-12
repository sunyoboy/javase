package com.sunlj.template;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;


import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;
import freemarker.template.TemplateScalarModel;

/**
 * �Զ����ǩ������
 * @author Administrator
 *
 */
public class ContentDirective implements TemplateDirectiveModel{

	private static final String PARAM_NAME = "name";
	private static final String PARAM_AGE = "age";
	
	public void execute(Environment env, Map params, TemplateModel[] loopVars, 
            TemplateDirectiveBody body) throws TemplateException, IOException {
		if(body==null){
			throw new TemplateModelException("null body");
		}else{
			String name = getString(PARAM_NAME, params);
			Integer age = getInt(PARAM_AGE, params);
			//���յ�����֮����Ը���������Ĳ�����Ȼ����������ҳ������ʾ������
			if(name!=null){
				env.setVariable("output", DEFAULT_WRAPPER.wrap("��ContentDirective�������л�õĲ����ǣ�"+name+", "));
			}
			if(age!=null){
				env.setVariable("append", DEFAULT_WRAPPER.wrap("���䣺"+age));
			}
			Writer out = env.getOut();
			out.write("���������������ҳ�濴����������ݣ�����document.writerд�����һ����<br/>");
			body.render(out);
			
			/*
		  	���ϸ�ĵĻ����ᷢ��ҳ��������ʾout.write�����������䣬Ȼ�������output�����ݣ�
			�ɼ� ��body�ڽ�����ʱ����ȰѲ�������env�У���ҳ��������Ӧ�Ķ�����ʱ�ĲŻ�ȥȡֵ
			���ǣ�����ñ�ʱ�����ڣ��ͻᱨ��  �Ҿ�������freemarkerû�����ã�������ʱ����ӻ�Ѵ���¶��ҳ���ϡ�
			�����������ֲ�${output!"null"},ʼ�ոо�û��el���ʽ�����á�
			*/
		}
	}
	
	/**
	 * ��ȡString���͵Ĳ�����ֵ
	 * @param paramName
	 * @param paramMap
	 * @return
	 * @throws TemplateModelException
	 */
	public static String getString(String paramName, Map<String, TemplateModel> paramMap) throws TemplateModelException{
		TemplateModel model = paramMap.get(paramName);
		if(model == null){
			return null;
		}
		if(model instanceof TemplateScalarModel){
			return ((TemplateScalarModel)model).getAsString();
		}else if (model instanceof TemplateNumberModel) {
			return ((TemplateNumberModel)model).getAsNumber().toString();
		}else{
			throw new TemplateModelException(paramName);
		}
	}
	
	/**
	 * 
	 * ���int���͵Ĳ���
	 * @param paramName
	 * @param paramMap
	 * @return
	 * @throws TemplateModelException 
	 */
	public static Integer getInt(String paramName, Map<String, TemplateModel> paramMap) throws TemplateModelException{
		TemplateModel model = paramMap.get(paramName);
		if(model==null){
			return null;
		}
		if(model instanceof TemplateScalarModel){
			String str = ((TemplateScalarModel)model).getAsString();
			try {
				return Integer.valueOf(str);
			} catch (NumberFormatException e) {
				throw new TemplateModelException(paramName);
			}
		}else if(model instanceof TemplateNumberModel){
			return ((TemplateNumberModel)model).getAsNumber().intValue();
		}else{
			throw new TemplateModelException(paramName);
		}
	}
}

