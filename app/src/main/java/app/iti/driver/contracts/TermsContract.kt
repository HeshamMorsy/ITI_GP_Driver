package app.iti.driver.contracts

interface TermsContract {
    interface Model {
        fun initModel(presenter: Presenter)
    }
    interface View {

    }
    interface Presenter {
        fun initPresenter(view: View)
    }
}