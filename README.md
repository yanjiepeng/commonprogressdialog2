# commonprogressdialog2
简易加载对话框

Module导入
动画采用帧布局

调用参考
```
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { showDialog() }
    }


    private fun showDialog() {
        val dialog = CommonProgressDialog.createDialog(this)
        dialog.setMessage(getString(R.string.loadiing))
        dialog.setMessageTextColor(R.color.colorBlue)
        dialog.show()
    }
}

```
