package com.techacademy.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techacademy.constants.ErrorKinds;
import com.techacademy.entity.Report;
import com.techacademy.repository.ReportRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ReportService(ReportRepository reportRepository, PasswordEncoder passwordEncoder) {
        this.reportRepository = reportRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 日報保存
    @Transactional
    public ErrorKinds save(Report report) {
        report.setDeleteFlg(false);
        
        LocalDateTime now = LocalDateTime.now();
        report.setCreatedAt(now);
        report.setUpdatedAt(now);
        
        reportRepository.save(report);
        return ErrorKinds.SUCCESS;
    }

      /*  // 日付チェック（日報テーブルに、「ログイン中の従業員 かつ 入力した日付」の日報データが存在する場合エラー）
        ErrorKinds result = (report);
        if (ErrorKinds.CHECK_OK != result) {
            return result;
        }
    
        // 従業員番号重複チェック
       // if (findByCode(employee.getCode()) != null) {
        //    return ErrorKinds.DUPLICATE_ERROR;
       // }

        report.setDeleteFlg(false);

        LocalDateTime now = LocalDateTime.now();
        report.setCreatedAt(now);
        report.setUpdatedAt(now);

        reportRepository.save(report);
        return ErrorKinds.SUCCESS;
}

    // 従業員更新
    /*@Transactional
    public ErrorKinds update(Employee employee,String code) {
        
        // 画面上からパスワードを取得→空
        // パスワードが空→findByで既存のパスワードを呼び出す
        Employee dbEmployee = findByCode(code);
        if ("".equals(employee.getPassword())) {
            employee.setPassword(dbEmployee.getPassword());

        } else {
            // パスワードを更新する場合→パスワードチェック
            ErrorKinds result = employeePasswordCheck(employee);
            if (ErrorKinds.CHECK_OK != result) {
                return result;
            }
        }
        employee.setDeleteFlg(false);

        LocalDateTime now = LocalDateTime.now();
        employee.setUpdatedAt(now);
        employee.setCreatedAt(dbEmployee.getCreatedAt());

        employeeRepository.save(employee);
        return ErrorKinds.SUCCESS;
    }

    // 従業員削除
    @Transactional
    public ErrorKinds delete(String code, UserDetail userDetail) {

        // 自分を削除しようとした場合はエラーメッセージを表示
        if (code.equals(userDetail.getEmployee().getCode())) {
            return ErrorKinds.LOGINCHECK_ERROR;
        }
        Employee employee = findByCode(code);
        LocalDateTime now = LocalDateTime.now();
        employee.setUpdatedAt(now);
        employee.setDeleteFlg(true);

        return ErrorKinds.SUCCESS;
    } */

    // 日報一覧表示処理
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    // 1件を検索
    //public Report findById(Integer id) {
        // findByIdで検索
      //  Optional<Report> option = reportRepository.findById(id);
        // 取得できなかった場合はnullを返す
       // Report report = option.orElse(null);
      //  return report;
  //  }

   //idを1件検索して返す 
    public Report getId(Integer id) {
    return reportRepository.findById(id).get();
}}

   /*// 従業員パスワードチェック
    private ErrorKinds employeePasswordCheck(Report report) {

        // 従業員パスワードの半角英数字チェック処理
        if (isHalfSizeCheckError(report)) {

            return ErrorKinds.HALFSIZE_ERROR;
        }

        // 従業員パスワードの8文字～16文字チェック処理
        if (isOutOfRangePassword(report)) {

            return ErrorKinds.RANGECHECK_ERROR;
        }

        report.setPassword(passwordEncoder.encode(report.getPassword()));

        return ErrorKinds.CHECK_OK;
    }}

    // 従業員パスワードの半角英数字チェック処理
    private boolean isHalfSizeCheckError(Employee employee) {

        // 半角英数字チェック
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
        Matcher matcher = pattern.matcher(employee.getPassword());
        return !matcher.matches();
    }

    // 従業員パスワードの8文字～16文字チェック処理
    public boolean isOutOfRangePassword(Employee employee) {

        // 桁数チェック
        int passwordLength = employee.getPassword().length();
        return passwordLength < 8 || 16 < passwordLength;
    }

}*/
