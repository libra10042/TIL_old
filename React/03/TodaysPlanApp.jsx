class TodaysPlanApp extends React.Component {
  render() {
    const { onButtonClick, hasPlan } = this.props;
    return (
      <div className="body">
        {hasPlan ? <TodysPlan /> : null}
        <button onClick={onButtonClick}>ęłíěě</button>
      </div>
    );
  }
}
