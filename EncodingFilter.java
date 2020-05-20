package tool;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// フィルタをすべてのサーブレット/JSPに適用する
@WebFilter(urlPatterns={"/*"})
public class EncodingFilter implements Filter {

// Filterインタフェースを実装する
// doFilter(),init(),destroy()の３つ
// doFilter()は引数を３つ持つことに注意
  public void doFilter(
    ServletRequest request, ServletResponse response,
    FilterChain chain
  ) throws IOException, ServletException {

    // リクエストの文字エンコーディング
    request.setCharacterEncoding("UTF-8");

    // レスポンスの文字エンコーディング
    response.setContentType("text/html; charset=UTF-8");

    // 動作確認
    // サーブレット,JSPが呼び出される前の処理
    System.out.println("フィルタの前処理");

    // FilterChainインタフェースのdoFilter()を実行
    // 他に実行すべきフィルタがあればそれを実行する
    chain.doFilter(request, response);

    // 動作確認
    // サーブレット,JSPが呼び出された後の処理
    System.out.println("フィルタの後処理");
  }

// 処理がなくてもオーバーライド必須
  public void init(FilterConfig filterConfig) {}
  public void destroy() {}

}
