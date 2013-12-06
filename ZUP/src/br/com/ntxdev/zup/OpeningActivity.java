package br.com.ntxdev.zup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import br.com.ntxdev.zup.util.FontUtils;
import br.com.ntxdev.zup.widget.ImagePagerAdapter;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

public class OpeningActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opening);
		
		ImagePagerAdapter mAdapter = new ImagePagerAdapter(getSupportFragmentManager());

		ViewPager mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		PageIndicator mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);
		
		((TextView) findViewById(R.id.labelNaoPossuiConta)).setTypeface(FontUtils.getRegular(this));
		((TextView) findViewById(R.id.labelPossuiConta)).setTypeface(FontUtils.getRegular(this));
		
		TextView linkPular = (TextView) findViewById(R.id.linkPular);
		linkPular.setTypeface(FontUtils.getBold(this));
		linkPular.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(OpeningActivity.this, MainActivity.class));
				finish();
			}			
		});
		
		Button botaoCadastrar = (Button) findViewById(R.id.botaoCadastrar);
		botaoCadastrar.setTypeface(FontUtils.getRegular(this));
		botaoCadastrar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(OpeningActivity.this, CadastroActivity.class));
			}			
		});
		
		Button botaoLogin = (Button) findViewById(R.id.botaoLogin);
		botaoLogin.setTypeface(FontUtils.getRegular(this));
		botaoLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(OpeningActivity.this, LoginActivity.class));
			}			
		});
	}
}