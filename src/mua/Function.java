package mua;

public class Function implements OpInterface {
    private int oprandNum;

    public Value runList;

    public Value paraList;

    public NameSpace local;

    Function(int n, Value v1, Value v2) {
        local = new NameSpace();
        oprandNum = n;
        paraList = v1;
        for (Value keyV : paraList.listElement)
            local.localVariables.put(keyV.getElement(), new Value(""));
        runList = v2;
    }

    public int getOpNum() {
        return oprandNum;
    }

    public String calc(Value[] args, NameSpace n) {
        String s = runList.getElement();
        Value[] a = new Value[1];
        a[0] = new Value(s);

        for (int i = 0; i < args.length; ++i) {
            local.localVariables.put(paraList.listElement.get(i).getElement(), args[i]);
        }
        return Operation.run.calc(a, local);
    }

}
