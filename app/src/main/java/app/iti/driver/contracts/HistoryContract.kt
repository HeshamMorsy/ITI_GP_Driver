package app.iti.driver.contracts

interface HistoryContract {
    interface Model {
        fun initModel(presenter: Presenter)
    }
    interface View {

    }
    interface Presenter {
        fun initPresenter(view: View)
    }
}