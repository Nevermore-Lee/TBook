package nevermore.io.tbook.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;

public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {
	/**
	 * �����Ķ���
	 */
	private Context context;
	/**
	 * ���
	 */
	private List<T> data;
	/**
	 * LayoutInflater
	 */
	private LayoutInflater inflater;

	/**
	 * ���췽��
	 * 
	 * @param context
	 *            Context���󣬲�����Ϊnull
	 * @param data
	 *            ���
	 */
	public BaseAdapter(Context context, List<T> data) {
		super();
		setContext(context);
		setData(data);
		setLayoutInflater();
	}

	/**
	 * ����Context����
	 * 
	 * @param context
	 *            Context���󣬲�����Ϊnull
	 */
	public final void setContext(Context context) {
		if (context == null) {
			throw new IllegalArgumentException("����Context������Ϊnull��");
		}
		this.context = context;
	}

	/**
	 * �������
	 * 
	 * @param data
	 *            ���
	 */
	public final void setData(List<T> data) {
		if (data == null) {
			data = new ArrayList<T>();
			Log.w("tedu", "Adapterʹ�õ����Ϊnull���Ѵ���Ϊ�µ�ArrayList���Ƽ�������");
		}
		this.data = data;
	}

	/**
	 * ��ȡContext����
	 * 
	 * @return Context����
	 */
	public final Context getContext() {
		return context;
	}

	/**
	 * ��ȡ��ݵ�List����
	 * 
	 * @return ��ݵ�List����
	 */
	public final List<T> getData() {
		return data;
	}

	/**
	 * ����LayoutInflater��ֵ
	 */
	private void setLayoutInflater() {
		inflater = LayoutInflater.from(context);
	}

	/**
	 * ��ȡLayoutInflater����
	 * 
	 * @return LayoutInflater����
	 */
	public final LayoutInflater getLayoutInflater() {
		return inflater;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// �����ӣ�
		return null;
	}

	@Override
	public long getItemId(int position) {
		// �����ӣ�
		return 0;
	}

}
